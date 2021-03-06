package Game;


public class Queen extends Piece{
	
	public Queen(String color, int x, int y, Board b){
		super(color, x, y, b);
		if (color.equalsIgnoreCase("white"))
			this.name = "Q";
		else
			this.name = "q";
	}
	
	public Boolean isValidMovement(int x, int y){
		//out of the board
		if ( x < 0 || x > 7 || y < 0 || y > 7 
				|| this.board.getPiece(x, y).getColor().equalsIgnoreCase(this.color))
			return false;
		
		//move to bottom
		if (this.posX < x && this.posY == y){
			for (int i = 1; i < x - this.posX; i++){
				if (!board.getPiece(this.posX + i, y).isEmpty())
					return false;
			}
			return true;
		}
		
		//move to top
		if (this.posX > x && this.posY == y){
			for (int i = 1; i < this.posX - x; i++){
				if (!board.getPiece(this.posX - i, y).isEmpty())
					return false;
			}
			return true;
		}
		
		//move to right
		if (this.posX == x && this.posY < y){
			for (int i = 1; i < y - this.posY; i++){
				if (!board.getPiece(x,this.posY + i).isEmpty())
					return false;
			}
			return true;
		}
		
		//move to left
		if (this.posX == x && this.posY > y){
			for (int i = 1; i < this.posY - y ; i++){
				if (!board.getPiece(x, this.posY - i).isEmpty())
					return false;
			}
			return true;
		}
		
		int distX = Math.abs(this.posX - x);
		int distY = Math.abs(this.posY - y);
		
		if (distX != distY)
			return false;
		
		if (this.posX > x && this.posY > y){
			for (int i = 1; i < distX ; i ++){
				if (!this.board.getPiece(this.posX - i, this.posY - i).isEmpty())
					return false;
			}
			return true;
		}
		
		if (this.posX < x && this.posY > y){
			for (int i = 1; i < distX ; i ++){
				if (!this.board.getPiece(this.posX + i, this.posY - i).isEmpty())
					return false;
			}
			return true;
		}
		
		if (this.posX > x && this.posY < y){
			for (int i = 1; i < distX ; i ++){
				if (!this.board.getPiece(this.posX - i, this.posY + i).isEmpty())
					return false;
			}
			return true;
		}
		
		if (this.posX < x && this.posY < y){
			for (int i = 1; i < distX ; i ++){
				if (!this.board.getPiece(this.posX + i, this.posY + i).isEmpty())
					return false;
			}
			return true;
		}
		
		return false;
	}
	
	public Boolean isQueen(){
		return true;
	}

}
