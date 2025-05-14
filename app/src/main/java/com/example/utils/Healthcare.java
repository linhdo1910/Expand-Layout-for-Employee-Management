package com.example.utils;

public class Healthcare {
    public static BMIStatus calculate_bmi(double height, double weight)
    {
        height = height / 100;
        double BMI=weight/Math.pow(height,2);
        String des="";
        if (BMI<18.5){
            des = "Gầy quá";
        }
        else if (BMI<23){
            des="Bình thường";
        }
        else{
            des= "Mập quá";
        }
        BMIStatus bmiStatus=new BMIStatus(BMI,des);
        return bmiStatus;
    }
}
