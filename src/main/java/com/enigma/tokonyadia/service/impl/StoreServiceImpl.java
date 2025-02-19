package com.enigma.tokonyadia.service.impl;

import com.enigma.tokonyadia.entity.Store;
import com.enigma.tokonyadia.model.response.StoreResponse;
import com.enigma.tokonyadia.repository.StoreRepository;
import com.enigma.tokonyadia.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Store create(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store getById(String id) {
        return storeRepository.findById(id).get();
    }

    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store update(Store store) {
        Store currentStore = getById(store.getId());
        if (currentStore != null){
            return storeRepository.save(store);
        }
        return null;
    }

    @Override
    public void delete(String id) {
        storeRepository.deleteById(id);
    }

    @Override
    public List<StoreResponse> getAllResponse() {
        List<Store> stores = storeRepository.findAll();
        List<StoreResponse> responses = new ArrayList<>();
        for (Store store : stores){
            StoreResponse response = StoreResponse.builder()
                    .id(store.getId())
                    .storeName(store.getName())
                    .address(store.getAddress())
                    .mobilePhone(store.getMobilePhone())
                    .noSiup(store.getNoSiup())
                    .build();
            responses.add(response);
        }

        return responses;
    }
}