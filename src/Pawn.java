public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Check if move is valid
        int direction = (super.color.equals("White")) ? 1 : -1;
        if (line + direction != toLine || column != toColumn) {
            if (line + 2 * direction != toLine || column != toColumn || line != 1 && line != 6) {
                return false;
            }
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

        // Check if pawn moves one or two squares forward on first move
        if ((line == 1 || line == 6) && Math.abs(line - toLine) > 2) {
            return false;
        } else if (Math.abs(line - toLine) > 1) {
            // Check if pawn moves more than one square forward
            return false;
        } else if (Math.abs(column - toColumn) > 1) {
            // Check if pawn moves diagonally
            return false;
        } else if (line == toLine && pieceAtDestination != null) {
            // Check if pawn moves forward but a piece is blocking its path
            return false;
        } else if (line + direction == toLine && pieceAtDestination != null) {
            // Check if pawn moves diagonally without capturing a piece
            return false;
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
