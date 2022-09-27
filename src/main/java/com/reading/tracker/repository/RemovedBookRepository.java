package com.reading.tracker.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reading.tracker.model.RemovedBook;

public interface RemovedBookRepository extends JpaRepository<RemovedBook, UUID> {

}
