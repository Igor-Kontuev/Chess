public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Check if move is valid
        if (line == toLine || column == toColumn || Math.abs(line - toLine) + Math.abs(column - toColumn) != 3) {
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

        return true;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}