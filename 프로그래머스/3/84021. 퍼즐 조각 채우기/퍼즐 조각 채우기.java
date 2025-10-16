import java.util.*;

class Block {
    int x;
    int y;

    Block(int y, int x) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return y + "," + x + ";"; // 정렬 기준을 위해 y를 앞으로 변경
    }
}

class Solution {
    private int[] dy = {-1, 0, 1, 0};
    private int[] dx = {0, 1, 0, -1};
    private List<Block> currentBlocks; // DFS 탐색 시 현재 모양을 저장하는 리스트
    private int n;

    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;

        // 각 보드별로 방문 여부를 체크할 배열
        boolean[][] boardVisited = new boolean[n][n];
        boolean[][] tableVisited = new boolean[n][n];

        // 1. 게임 보드에서 빈 공간(0)들을 모두 찾아서 리스트에 저장
        List<List<Block>> emptySpaces = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game_board[i][j] == 0 && !boardVisited[i][j]) {
                    currentBlocks = new ArrayList<>();
                    dfs(i, j, boardVisited, game_board, 0); // 하나의 연결된 빈 공간 탐색
                    emptySpaces.add(currentBlocks);
                }
            }
        }

        // 2. 테이블에서 퍼즐 조각(1)들을 모두 찾아서 리스트에 저장
        List<List<Block>> puzzlePieces = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == 1 && !tableVisited[i][j]) {
                    currentBlocks = new ArrayList<>();
                    dfs(i, j, tableVisited, table, 1); // 하나의 연결된 퍼즐 조각 탐색
                    puzzlePieces.add(currentBlocks);
                }
            }
        }

        // 3. 찾은 빈 공간과 퍼즐 조각을 비교하여 정답 계산
        int answer = 0;
        boolean[] usedPieces = new boolean[puzzlePieces.size()]; // 사용한 퍼즐 조각인지 체크

        for (List<Block> space : emptySpaces) {
            for (int i = 0; i < puzzlePieces.size(); i++) {
                // 이미 사용한 조각이면 건너뛰기
                if (usedPieces[i]) {
                    continue;
                }

                List<Block> piece = puzzlePieces.get(i);

                // 빈 공간과 퍼즐 조각의 크기(칸 수)가 다르면 절대 맞출 수 없음
                if (space.size() != piece.size()) {
                    continue;
                }

                // 4번 회전(0, 90, 180, 270도)하며 모양이 일치하는지 확인
                if (isMatch(space, piece)) {
                    answer += piece.size(); // 일치하면 칸 수만큼 정답에 추가
                    usedPieces[i] = true;   // 이 조각은 사용 처리
                    break; // 맞는 조각을 찾았으니 다음 빈 공간으로 넘어감
                }
            }
        }

        return answer;
    }
    
    /**
     * 하나의 빈 공간(space)과 하나의 퍼즐 조각(piece)이 일치하는지 확인하는 메서드.
     * 퍼즐 조각을 4번 회전시키며 모양을 비교합니다.
     */
    private boolean isMatch(List<Block> space, List<Block> piece) {
        // 빈 공간의 모양을 정규화 (기준 모양이 됨)
        String normalizedSpace = normalize(space);

        List<Block> currentPiece = new ArrayList<>(piece);
        for (int r = 0; r < 4; r++) { // 4번 회전
            // 현재 회전 상태의 퍼즐 조각 모양을 정규화
            String normalizedPiece = normalize(currentPiece);
            
            if (normalizedSpace.equals(normalizedPiece)) {
                return true; // 모양이 일치하면 true 반환
            }
            
            // 일치하지 않으면 시계 방향으로 90도 회전
            // 회전 공식: (y, x) -> (x, -y)
            List<Block> rotated = new ArrayList<>();
            for (Block b : currentPiece) {
                rotated.add(new Block(b.x, -b.y));
            }
            currentPiece = rotated;
        }
        
        return false; // 4번 모두 회전해도 모양이 다르면 false 반환
    }

    /**
     * DFS(깊이 우선 탐색)로 연결된 블록(빈 공간 또는 퍼즐 조각)을 찾는 메서드.
     */
    private void dfs(int y, int x, boolean[][] visited, int[][] grid, int targetValue) {
        visited[y][x] = true;
        currentBlocks.add(new Block(y, x));

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            // 배열 경계를 벗어나지 않고, 방문하지 않았으며, 찾으려는 값(0 또는 1)과 일치하는 경우에만 탐색 계속
            if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < n &&
                !visited[nextY][nextX] && grid[nextY][nextX] == targetValue) {
                dfs(nextY, nextX, visited, grid, targetValue);
            }
        }
    }

    // 오버로딩 1: 스스로 기준점을 찾아 정규화하는 버전 (회전된 블록용)
    private String normalize(List<Block> blocks) {
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        for (Block b : blocks) {
            minY = Math.min(minY, b.y);
            minX = Math.min(minX, b.x);
        }
        return normalize(blocks, minY, minX);
    }
    
    // 오버로딩 2: 기준점(minY, minX)을 전달받아 정규화하는 버전 (핵심 로직)
    private String normalize(List<Block> blocks, int minY, int minX) {
        List<Block> normalizedBlocks = new ArrayList<>();
        for (Block b : blocks) {
            normalizedBlocks.add(new Block(b.y - minY, b.x - minX));
        }

        // y좌표 우선, 그 다음 x좌표 순으로 정렬하여 모양을 유일한 문자열로 만듭니다.
        normalizedBlocks.sort(Comparator.comparingInt((Block b) -> b.y).thenComparingInt((Block b) -> b.x));

        StringBuilder sb = new StringBuilder();
        for (Block b : normalizedBlocks) {
            sb.append(b.toString());
        }
        return sb.toString();
    }
}