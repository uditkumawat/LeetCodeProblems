package code.top100;

import java.util.*;

public class FileSharingSystem {


        Map<Integer, Set<Integer>> file_user = new HashMap<>();
        Map<Integer, Set<Integer>> user_file = new HashMap<>();
        PriorityQueue<Integer> recycle = new PriorityQueue<>();

        public FileSharingSystem(int m) {
        }

        public int join(List<Integer> ownedChunks) {
            int id = recycle.isEmpty() ? user_file.size() + 1 : recycle.poll();
            user_file.put(id, new HashSet<>(ownedChunks));
            for (int c : ownedChunks) {
                file_user.computeIfAbsent(c, key -> new TreeSet<>()).add(id);
            }
            return id;
        }

        public void leave(int userID) {
            recycle.offer(userID);
            for (int c : user_file.get(userID)) {
                file_user.get(c).remove(userID);
            }
            user_file.remove(userID);
        }

        public List<Integer> request(int userID, int chunkID) {
            List<Integer> res = new ArrayList<>(file_user.getOrDefault(chunkID, new HashSet<>()));
            if (!res.isEmpty()) {
                user_file.get(userID).add(chunkID);
                file_user.get(chunkID).add(userID);
            }
            return res;
        }

}
