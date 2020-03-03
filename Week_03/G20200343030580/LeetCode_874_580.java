class Solution {
    private enum Direction {
        N {
            @Override
            public Direction changeDirection(int change) {
                switch (change) {
                    case -1:
                        return E;
                    case -2:
                        return W;
                }
                return this;
            }

            @Override
            public int moveX(int currentX, int step, SortedSet<Integer> os) {
                return currentX;
            }

            @Override
            public int moveY(int currentY, int step, SortedSet<Integer> os) {
                SortedSet<Integer> subset = os.subSet(currentY, currentY + step + 1);
                if (subset != null && subset.size() > 0) {
                    return subset.first() == currentY ? currentY + step : subset.first() - 1;
                }
                return currentY + step;
            }
        }, S {
            @Override
            public Direction changeDirection(int change) {
                switch (change) {
                    case -1:
                        return W;
                    case -2:
                        return E;
                }
                return this;
            }

            @Override
            public int moveX(int currentX, int step, SortedSet<Integer> os) {
                return currentX;
            }

            @Override
            public int moveY(int currentY, int step, SortedSet<Integer> os) {
                SortedSet<Integer> subset = os.subSet(currentY - step - 1, currentY);
                if (subset != null && subset.size() > 0) {
                    return subset.last() == currentY ? currentY - step : subset.last() + 1;
                }
                return currentY - step;
            }
        }, W {
            @Override
            public Direction changeDirection(int change) {
                switch (change) {
                    case -1:
                        return N;
                    case -2:
                        return S;
                }
                return this;
            }

            @Override
            public int moveX(int currentX, int step, SortedSet<Integer> os) {
                SortedSet<Integer> subset = os.subSet(currentX - step - 1, currentX);
                if (subset != null && subset.size() > 0) {
                    return subset.last() == currentX ? currentX - step : subset.last() + 1;
                }
                return currentX - step;
            }

            @Override
            public int moveY(int currentY, int step, SortedSet<Integer> os) {
                return currentY;
            }
        }, E {
            @Override
            public Direction changeDirection(int change) {
                switch (change) {
                    case -1:
                        return S;
                    case -2:
                        return N;
                }
                return this;

            }

            @Override
            public int moveX(int currentX, int step, SortedSet<Integer> os) {
                SortedSet<Integer> subset = os.subSet(currentX, currentX + step + 1);
                if (subset != null && subset.size() > 0) {
                    return subset.first() == currentX ? currentX + step : subset.first() - 1;
                }
                return currentX + step;
            }

            @Override
            public int moveY(int currentY, int step, SortedSet<Integer> os) {
                return currentY;
            }
        };

        public abstract Direction changeDirection(int change);

        public abstract int moveX(int currentX, int step, SortedSet<Integer> os);

        public abstract int moveY(int currentY, int step, SortedSet<Integer> os);


    }


    public int robotSim(int[] commands, int[][] obstacles) {
        Direction d = Direction.N;
        int x = 0;
        int y = 0;
        int result = 0;
        Map<Integer, SortedSet<Integer>> xmap = new HashMap<>();
        Map<Integer, SortedSet<Integer>> ymap = new HashMap<>();
        for (int[] obstacle : obstacles) {
            Integer ox = obstacle[0];
            Integer oy = obstacle[1];
            SortedSet<Integer> xset = xmap.getOrDefault(ox, new TreeSet<>());
            xset.add(oy);
            xmap.put(ox, xset);
            SortedSet<Integer> yset = ymap.getOrDefault(oy, new TreeSet<>());
            yset.add(ox);
            ymap.put(oy, yset);
        }
        SortedSet<Integer> emptySet = new TreeSet<>();
        for (int command : commands) {
            if (command < 0) {
                d = d.changeDirection(command);
            } else {
                SortedSet<Integer> xob = ymap.getOrDefault(y, emptySet);
                SortedSet<Integer> yob = xmap.getOrDefault(x, emptySet);
                x = d.moveX(x, command, xob);
                y = d.moveY(y, command, yob);
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }
}
