import java.util.*;

class Solution {

    static class Coordinate{
        int x, y;
        int cross = 0;
        int direct = -1;
        public Coordinate(int x, int y, int cross, int direct){
            this.x = x;
            this.y = y;
            this.cross = cross;
            this.direct = direct;
        }
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static int[] bfs(int m, int n, Coordinate c, char[][] b){
        boolean[][] check = new boolean[m][n];
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(c);

        while(!queue.isEmpty()){
            Coordinate coordinate = queue.poll();
            if(!check[coordinate.x][coordinate.y]) check[coordinate.x][coordinate.y] = true;

            if(coordinate.direct != -1){
                if(b[c.x][c.y] == b[coordinate.x][coordinate.y]) {
                    b[c.x][c.y] = '.';
                    b[coordinate.x][coordinate.y] = '.';
                    return new int[]{coordinate.x, coordinate.y};
                }
                else if(b[coordinate.x][coordinate.y] != '.') continue;
            }

            if(coordinate.y > 0 && !check[coordinate.x][coordinate.y-1]) {
                int cross = coordinate.cross;
                if(coordinate.direct != 0) cross++;
                if(cross <= 2) queue.add(new Coordinate(coordinate.x, coordinate.y-1, cross, 0));
            }
            if(coordinate.y+1 < n && !check[coordinate.x][coordinate.y+1]) {
                int cross = coordinate.cross;
                if(coordinate.direct != 2) cross++;
                if(cross <= 2) queue.add(new Coordinate(coordinate.x, coordinate.y+1, cross, 2));
            }
            if(coordinate.x+1 < m && !check[coordinate.x+1][coordinate.y]) {
                int cross = coordinate.cross;
                if(coordinate.direct != 1) cross++;
                if(cross <= 2) queue.add(new Coordinate(coordinate.x+1, coordinate.y, cross, 1));
            }
        }


        return new int[]{-1, -1};
    }


    public static String solution(int m, int n, String[] board) {
        StringBuilder answer = new StringBuilder();
        Map<Character, Coordinate> map = new HashMap<>();
        Set<Character> set = new TreeSet<>();
        char[][] b = new char[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                b[i][j] = board[i].charAt(j);
                if (Character.isAlphabetic(b[i][j])) {
                    set.add(b[i][j]);
                    if(map.get(b[i][j]) == null) map.put(b[i][j], new Coordinate(i, j));
                }
            }

        List<Character> list = new ArrayList<>(set);
        int index = 0;
        while(!list.isEmpty() && list.size() > index){
            char c = list.get(index);
            int[] arr = bfs(m,n, map.get(c), b);
            if(arr[0] != -1) {
                answer.append(c);
                list.remove(index);
                index = 0;
            }
            else index++;
        }

        return (answer.length() == set.size() ) ? answer.toString() : "IMPOSSIBLE";
    }
}