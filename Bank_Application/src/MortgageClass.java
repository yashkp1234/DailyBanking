/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */

// By Akash
public class MortgageClass {

    
    int calculateTerm (double monthlyPayment, double interestRate, double maxMortgage){
        int term = (int)((maxMortgage * (100 * interestRate) / monthlyPayment) - 1); //to find the amount of term to pay off mortgage
        return term;
    }
    
    double calculateMonthlyPayment (int term, double interestRate, double maxMortgage){
        double monthlyPayment = maxMortgage * 100 / (1 + (interestRate * term)); //to find the max monthly payment
        return monthlyPayment;
    }
    
    double calculateMaxMortgage (int term, double interestRate, double monthlyPayment){
        double maxMortgage = monthlyPayment * (1 + (interestRate * term) / 100); //to find the max amount of mortgage you can take out
        return maxMortgage;
    }
    
    double calculateInterestRate (int term, double maxMortgage, double monthlyPayment){
        double interestRate = (maxMortgage * (100 * term) / monthlyPayment) - 1; //to find the monthly interest rate
        return interestRate ;
    }
}

    