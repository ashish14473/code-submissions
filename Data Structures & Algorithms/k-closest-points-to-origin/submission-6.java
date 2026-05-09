
class Solution {
    class Distance {
        double distance;
        int index;

         @Override
        public String toString() {
            return "Distance{" + "distance=" + distance + 
                   ", index=" + index + '}';
        }
    }
    public int[][] kClosest(int[][] points, int k) {

        Distance[] dis = new Distance[points.length];

        for(int i=0;i<points.length;i++){
            dis[i] = new Distance();
            dis[i].distance = Math.sqrt(points[i][0]*points[i][0]+points[i][1]*points[i][1]);
            dis[i].index = i;
        }

        for(int i = (dis.length/2-1);i>=0;i--){
            heapifydown(dis ,dis.length , i);
        }
          System.out.println(Arrays.toString(dis));
int[][] res = new int[k][2];
    for(int i=0;i<k;i++){
       res[i][0] =  points[dis[0].index][0];
       res[i][1] =  points[dis[0].index][1];
       Distance temp = dis[0];
            dis[0] = dis[dis.length-(i+1)];
            dis[dis.length-(i+1)] = temp;
            heapifydown(dis ,dis.length-(i+1) , 0);
           
    }
   
return res;
    }


    void heapifydown(Distance[] dis ,int size , int i){
        int lc = 2*i+1;
        int rc = 2*i+2;

        int smallest =i;
        if(lc < size && dis[lc].distance < dis[smallest].distance){
            smallest = lc;
        }
        if(rc < size && dis[rc].distance < dis[smallest].distance){
             smallest = rc;
        }

        if(smallest!=i){
            Distance temp = dis[i];
            dis[i] = dis[smallest];
            dis[smallest] = temp;
            heapifydown(dis ,size , smallest);
        }

    }
}
