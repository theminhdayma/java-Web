package com.data.session03;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;
    private int nextId;

    public UserManager() {
        users = new ArrayList<>();
        nextId = 1; // Bắt đầu ID từ 1
    }

    // Thêm người dùng
    public void addUser(User user) {
        user.setId(nextId++);
        users.add(user);
    }

    // Lấy danh sách người dùng
    public List<User> getUsers() {
        return users;
    }

    // Xóa người dùng theo ID
    public void removeUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
