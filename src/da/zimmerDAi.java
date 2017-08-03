package da;
import java.util.List;

import model.zimmer;
public interface zimmerDAi {
	
		
		public void addZimmer (zimmer zimmer);
		public List <zimmer> getAllZimmer();
		public zimmer getZimmerById (int zimmer_id);
		public void updateZimmer (zimmer zimmer);
		public void delete (int zimmer_id);
			
		
	
}
