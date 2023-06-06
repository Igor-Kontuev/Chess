public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line < 0 || line > 7 || column < 0 || column > 7 ||
                toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            // Фигура не может выйти за пределы доски
            return false;
        }
        if (line == toLine && column == toColumn) {
            // Фигура не может сходить в точку, в которой она сейчас находится
            return false;
        }
        if (Math.abs(line - toLine) > 1 || Math.abs(column - toColumn) > 1) {
            // Король может ходить только на одну клетку вокруг себя
            return false;
        }
        return true;
    }

    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        // Проверяем, атакует ли какая-то фигура короля
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board.getPieceAt(i, j);
                if (piece != null &&
                        !piece.getColor().equals(color) &&
                        piece.canMoveToPosition(board, i, j, line, column)) {
                    return true;
                }
            }
        }
        return false;
    }
}
