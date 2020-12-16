package rummikub;

public enum SteenColor {
    RED {
        @Override
        public String toString() {
            return "\u001B[31m";
        }
    }, BLACK {
        @Override
        public String toString() {
            return "\u001B[30m";
        }
    }, BLUE {
        @Override
        public String toString() {
            return "\u001B[34m";
        }
    }, YELLOW {
        @Override
        public String toString() {
            return "\u001B[33m";
        }
    }, RESET {
        @Override
        public String toString() {
            return "\u001B[0m";
        }
    };

}
