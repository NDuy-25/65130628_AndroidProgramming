package com.duy.demo_note;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText edtNote;
    private Button btnAddNote, btnLogout;
    private ListView listViewNotes;

    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    
    private ArrayList<String> noteList;
    private ArrayList<String> noteIds; // Lưu ID để xóa
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        // Kiểm tra đăng nhập
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
            return;
        }

        edtNote = findViewById(R.id.edtNote);
        btnAddNote = findViewById(R.id.btnAddNote);
        btnLogout = findViewById(R.id.btnLogout);
        listViewNotes = findViewById(R.id.listViewNotes);

        noteList = new ArrayList<>();
        noteIds = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, noteList);
        listViewNotes.setAdapter(adapter);

        // Lấy dữ liệu từ Firestore
        loadNotes();

        btnAddNote.setOnClickListener(v -> {
            String content = edtNote.getText().toString().trim();
            if (!content.isEmpty()) {
                addNoteToFirestore(content);
            } else {
                Toast.makeText(this, "Vui lòng nhập ghi chú", Toast.LENGTH_SHORT).show();
            }
        });

        // Click giữ để xóa
        listViewNotes.setOnItemLongClickListener((parent, view, position, id) -> {
            if (position >= 0 && position < noteIds.size()) {
                String noteId = noteIds.get(position);
                deleteNote(noteId);
            }
            return true;
        });

        btnLogout.setOnClickListener(v -> {
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        });
    }

    private void loadNotes() {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) return;

        db.collection("notes")
                .whereEqualTo("userId", user.getUid())
                .addSnapshotListener((value, error) -> {
                    if (error != null) {
                        Toast.makeText(this, "Lỗi tải dữ liệu", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (value != null) {
                        noteList.clear();
                        noteIds.clear();
                        for (QueryDocumentSnapshot doc : value) {
                            String content = doc.getString("content");
                            noteList.add(content != null ? content : "");
                            noteIds.add(doc.getId());
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    private void addNoteToFirestore(String content) {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) return;

        Map<String, Object> note = new HashMap<>();
        note.put("content", content);
        note.put("userId", user.getUid());

        db.collection("notes")
                .add(note)
                .addOnSuccessListener(documentReference -> {
                    edtNote.setText("");
                    Toast.makeText(this, "Đã thêm ghi chú", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Lỗi: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    private void deleteNote(String noteId) {
        db.collection("notes").document(noteId)
                .delete()
                .addOnSuccessListener(aVoid -> Toast.makeText(this, "Đã xóa ghi chú", Toast.LENGTH_SHORT).show())
                .addOnFailureListener(e -> Toast.makeText(this, "Lỗi xóa: " + e.getMessage(), Toast.LENGTH_SHORT).show());
    }
}
