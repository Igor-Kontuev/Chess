public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Check if move is valid
        if (Math.abs(line - toLine) != Math.abs(column - toColumn)) {
            return false;
        }

        // Check if destination position is out of board range
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }

        // Check if the piece is at the destination position
        if (line == toLine && column == toColumn) {
            return false;
        }

        // Check if there is no other piece of the same color at the destination position
        ChessPiece pieceAtDestination = chessBoard.getPieceAt(toLine, toColumn);
        if (pieceAtDestination != null && pieceAtDestination.getColor().equals(super.color)) {
            return false;
        }

        // Check if there are any pieces blocking the path of the bishop
        int xDirection = (toLine - line > 0) ? 1 : -1;
        int yDirection = (toColumn - column > 0) ? 1 : -1;
        for (int i = 1; i < Math.abs(line - toLine); i++) {
            if (chessBoard.getPieceAt(line + i * xDirection, column + i * yDirection) != null) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
