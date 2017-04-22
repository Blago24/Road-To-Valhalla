package sizes;

public class SizesOfObjectsOnTheMap {

		public float checkTheTypeForHeight(int type){
			if(type>=0 && type<=6){
				return 46;
			}else if(type==11){
				
				return 46*4;
			}else if(type==10){
				
				return 46*3;
			}
			else{
				return 46*2;
			}
		}
		public float checkTheTypeForWidth(int type){
			if(type>=0 && type<=6){
				return 46;
			}else if(type==11){
				
				return 46;
			}
			else if(type==10){
				
				return 46*3;
			}
			else{
				return 46*2;
			}
		}
	}

