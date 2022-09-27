package com.reading.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reading.tracker.model.KeySearch;

public interface KeySearchRepository extends JpaRepository<KeySearch, String> {

}
