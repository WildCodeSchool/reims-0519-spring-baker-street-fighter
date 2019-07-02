package com.wildcodeschool.bakerStreetFighter.repositories;

class FighterRepository {

    public int getRiskRandomAttack() {
        double probability = Math.random();
        int randomRiskAttackDamage = 30;
        if (probability > 0.5) {
            return randomRiskAttackDamage;
        } 
        return 0;
    }

    public int getSafeRandomAttack() {
        double probability = Math.random();
        int randomSafeAttackDamage = 10;
        
        if (probability > 0.2) {
            return randomSafeAttackDamage;
        } 
        return 0;
    }

}