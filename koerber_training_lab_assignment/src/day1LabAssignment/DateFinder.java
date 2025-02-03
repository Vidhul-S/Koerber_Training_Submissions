package day1LabAssignment;

import java.util.Scanner;

public class DateFinder {
    Date dat ;
    public Date nextDate (Date da){
        int d=da.date,m=da.month,y=da.year;
        if(d==31 || d==29 || d==30 || d==28){
            switch(m) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:

                    dat = new Date(1,m+1,y);
                    break;
                case 12:

                    dat = new Date(1,1,y+1);
                    break;
                case 2:

                    if(d==28 &&(y%4==0 && (y%100!=0 || y%400==0))){

                        dat = new Date(d+1,m,y);
                    }
                    else if(!(d==28 &&(y%4==0 && (y%100!=0 || y%400==0)))){

                        dat = new Date(1,m+1,y);
                    }
                    else{

                        dat = new Date(1,m+1,y);
                    }
                    break;
                default:

                    break;
            }
        }
        else{

            dat = new Date(d+1,m,y);
        }
        return dat;
    }
    public static void main(String [] args){
        Scanner s= new Scanner(System.in);
        DateFinder f = new DateFinder();
        System.out.println("Enter Year");
        int y= s.nextInt();
        System.out.println("Enter Month");
        int m= s.nextInt();
        System.out.println("Enter Date");
        int d= s.nextInt();
        Date da = new Date(d,m,y);
        da=f.nextDate(da);
        System.out.println("Next date is :\n"+da.date+"\\"+da.month+"\\"+da.year);
    }

}
class Date{
    public int date;
    public int month;
    public int year;
    public Date(int d,int m,int y){
        this.date=d;
        this.month=m;
        this.year=y;
    }
}

