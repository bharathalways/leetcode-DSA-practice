class Robot {
    int w, h;
    int x = 0, y = 0;
    int dir = 0;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    String[] dname = {"East", "North", "West", "South"};
    int cycle;

    public Robot(int width, int height) {
        w = width;
        h = height;
        cycle = 2 * (w + h - 2);
    }
    
    public void step(int num) {
        num %= cycle;
        
        if (num == 0) {
            if (x == 0 && y == 0) dir = 3;
            return;
        }
        
        while (num-- > 0) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx < 0 || nx >= w || ny < 0 || ny >= h) {
                dir = (dir + 1) % 4;
                num++;
                continue;
            }
            
            x = nx;
            y = ny;
        }
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        return dname[dir];
    }
}