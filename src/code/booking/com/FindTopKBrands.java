package code.booking.com;

import java.util.*;

// Question asked to me in coding round of booking.com
public class FindTopKBrands {

    class TopBrands {
        public int hotelId;
        public int totalNumberOfHotels;

        TopBrands(int hotelId, int totalNumberOfHotels) {
            this.totalNumberOfHotels = totalNumberOfHotels;
            this.hotelId = hotelId;
        }

        public int getHotelId() {
            return hotelId;
        }

        public int getTotalNumberOfHotels() {
            return totalNumberOfHotels;
        }

        public void setHotelId(int hotelId) {
            this.hotelId = hotelId;
        }

        public void setTotalNumberOfHotels(int totalNumberOfHotels) {
            this.totalNumberOfHotels = totalNumberOfHotels;
        }
    }

    public static void main(String[] args) {

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{3, 0, 14});
        list.add(new int[]{0, -1, 10});
        list.add(new int[]{4, 0, 44});
        list.add(new int[]{6, -1, 7});
        list.add(new int[]{10, 6, 13});
        list.add(new int[]{7, 6, 17});
        list.add(new int[]{2, -1, 2});
        list.add(new int[]{25, 14, 10});
        list.add(new int[]{12, 2, 10});
        list.add(new int[]{13, 0, 1});
        list.add(new int[]{14, 2, 9});

        int k = 2;
        FindTopKBrands obj = new FindTopKBrands();

        List<TopBrands> topBrands = obj.findMaxHotels(list, k);

        for (TopBrands topBrand : topBrands) {
            System.out.println(topBrand.getHotelId() + " " + topBrand.getTotalNumberOfHotels());
        }
    }

    public List<TopBrands> findMaxHotels(List<int[]> list, int k) {

        List<TopBrands> topBrands = new ArrayList<>();

        Map<Integer, Integer> childIdParentIdMap = new HashMap();
        Map<Integer, Integer> parentTotalHotelsMap = new HashMap<>();

        for (int data[] : list) {
            childIdParentIdMap.put(data[0], data[1]);
        }

        for (int data[] : list) {
            int hotelId = data[0];
            int parentId = 0;

            while (hotelId != -1) {
                parentId = hotelId;
                hotelId = childIdParentIdMap.get(hotelId);
            }

            parentTotalHotelsMap.put(parentId, parentTotalHotelsMap.getOrDefault(parentId, 0) + data[2]);
        }


        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>((entry1, entry2) -> {
            return entry1.getValue() - entry2.getValue();
        });

        for (Map.Entry<Integer, Integer> entry : parentTotalHotelsMap.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            topBrands.add(0, new TopBrands(entry.getKey(), entry.getValue()));
        }

        return topBrands;
    }
}
