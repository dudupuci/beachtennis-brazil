package br.com.beachtennisbrazil.api.app.service;

import br.com.beachtennisbrazil.api.app.entities.SubscriptionPlan;

import java.util.List;
import java.util.UUID;

public interface SubscriptionPlanServiceInterface {
    List<SubscriptionPlan> findAll();
    SubscriptionPlan findById(UUID id);
    void save(SubscriptionPlan plan);
    void updateData(SubscriptionPlan oldPlan, SubscriptionPlan newPlan);
    void updateAndSavePlan(UUID id, SubscriptionPlan newPlan);
    void deletePlanById(UUID id);
}
