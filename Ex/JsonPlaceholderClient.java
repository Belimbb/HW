package ForGit.Ex;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonPlaceholderClient {

    public String createUser(String json) {
        String url = "https://jsonplaceholder.typicode.com/users";
        try {
            Document response = Jsoup.connect(url)
                    .requestBody(json)
                    .header("Content-Type", "application/json")
                    .method(org.jsoup.Connection.Method.POST)
                    .ignoreContentType(true)
                    .execute()
                    .parse();
            return response.body().text();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String updateUser(int userId, String json) {
        String url = "https://jsonplaceholder.typicode.com/users/" + userId;
        try {
            Document response = Jsoup.connect(url)
                    .requestBody(json)
                    .header("Content-Type", "application/json")
                    .method(org.jsoup.Connection.Method.PUT)
                    .ignoreContentType(true)
                    .execute()
                    .parse();
            return response.body().text();
        } catch (Exception e) {
            return "Current user isn't in db";
        }
    }
    public int deleteUser(int userId) {
        String url = "https://jsonplaceholder.typicode.com/users/" + userId;
        try {
            return Jsoup.connect(url)
                    .method(org.jsoup.Connection.Method.DELETE)
                    .ignoreContentType(true)
                    .execute()
                    .statusCode();
        } catch (Exception e) {
            return -1;
        }
    }
    public String getAllUsers() {
        String url = "https://jsonplaceholder.typicode.com/users";
        try {
            Document response = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .execute()
                    .parse();
            return response.body().text();
        } catch (Exception e) {
            return "No users";
        }
    }
    public String getUserById(int userId) {
        String url = "https://jsonplaceholder.typicode.com/users/" + userId;
        try {
            Document response = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .execute()
                    .parse();
            return response.body().text();
        } catch (Exception e) {
            return "incorrect Id";
        }
    }
    public String getUserByUsername(String username) {
        String url = "https://jsonplaceholder.typicode.com/users?username=" + username;
        try {
            Document response = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .execute()
                    .parse();
            return response.body().text();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void fetchAndWriteCommentsOfLastPost(int userId) {
        String postsUrl = "https://jsonplaceholder.typicode.com/users/" + userId + "/posts";
        try {
            String postsResponse = Jsoup.connect(postsUrl).ignoreContentType(true).execute().body();
            JSONArray posts = new JSONArray(postsResponse);

            int lastPostId = 0;
            for (int i = 0; i < posts.length(); i++) {
                JSONObject post = posts.getJSONObject(i);
                int postId = post.getInt("id");
                if (postId > lastPostId) {
                    lastPostId = postId;
                }
            }

            String commentsUrl = "https://jsonplaceholder.typicode.com/posts/" + lastPostId + "/comments";
            String commentsResponse = Jsoup.connect(commentsUrl).ignoreContentType(true).execute().body();

            String fileName = "user-" + userId + "-post-" + lastPostId + "-comments.json";
            try (FileWriter file = new FileWriter(fileName)) {
                file.write(commentsResponse);
                System.out.println("Коментарі збережені у файлі " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void printOpenTasks(int userId) {
        String todosUrl = "https://jsonplaceholder.typicode.com/users/" + userId + "/todos";
        try {
            String todosResponse = Jsoup.connect(todosUrl).ignoreContentType(true).execute().body();
            JSONArray todos = new JSONArray(todosResponse);

            for (int i = 0; i < todos.length(); i++) {
                JSONObject todo = todos.getJSONObject(i);
                if (!todo.getBoolean("completed")) {
                    System.out.println(todo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

