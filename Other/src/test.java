import javafx.scene.shape.Circle;

import java.util.Date;
import java.util.List;


public class test {
    public static void main(String[] args) {
      int x=4;
        System.out.println("a "+((x>4)?99.9:9));


       }
       public float getAvgTravel(int beginAddress, int endAddress, List<ShootCar> ShootCars){
        long time=0;
        for(ShootCar sc:ShootCars){
            if(sc.getShootTime().equals(beginAddress)){
                time-=sc.getShootTime().getTime();
            }else {
                time+=sc.getShootTime().getTime();
            }
        }
        return (float)time/ShootCars.size()*2;
       }
       
        
    }
    class ShootCar{
    private  int adrId;
    private  String carNum;
    private Date shootTime;

        public int getAdrId() {
            return adrId;
        }

        public void setAdrId(int adrId) {
            this.adrId = adrId;
        }

        public String getCarNum() {
            return carNum;
        }

        public void setCarNum(String carNum) {
            this.carNum = carNum;
        }

        public Date getShootTime() {
            return shootTime;
        }

        public void setShootTime(Date shootTime) {
            this.shootTime = shootTime;
        }
    }

