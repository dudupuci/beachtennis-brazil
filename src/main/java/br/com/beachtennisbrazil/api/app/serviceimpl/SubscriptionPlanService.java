package br.com.beachtennisbrazil.api.app.serviceimpl;

import br.com.beachtennisbrazil.api.app.entities.SubscriptionPlan;
import br.com.beachtennisbrazil.api.app.repositories.SubscriptionPlanRepository;
import br.com.beachtennisbrazil.api.app.service.SubscriptionPlanServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SubscriptionPlanService implements SubscriptionPlanServiceInterface {

    @Autowired
    private SubscriptionPlanRepository repository;


    @Override
    public List<SubscriptionPlan> findAll() {
        return repository.findAll();
    }

    @Override
    public SubscriptionPlan findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }

    @Override
    public void save(SubscriptionPlan plan) {
        try {
            repository.save(plan);
        } catch (Exception err) {
            throw new RuntimeException("" + err.getMessage());
        }
    }

    @Override
    public void updateData(SubscriptionPlan oldPlan, SubscriptionPlan newPlan) {

    }

    @Override
    public void updateAndSavePlan(UUID id, SubscriptionPlan newPlan) {

    }

    @Override
    public void deletePlanById(UUID id) {

    }
}
