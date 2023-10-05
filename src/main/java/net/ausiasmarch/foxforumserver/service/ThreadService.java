package net.ausiasmarch.foxforumserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.foxforumserver.entity.ThreadEntity;
import net.ausiasmarch.foxforumserver.exception.ResourceNotFoundException;
import net.ausiasmarch.foxforumserver.repository.ThreadRepository;

@Service
public class ThreadService {
    
    @Autowired
    private ThreadRepository threadRepository;

    public ThreadEntity get(Long id) {
        return threadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Thread not found"));
    }

    public ThreadEntity create(ThreadEntity threadEntity) {
        threadEntity.setId(null);
        return threadRepository.save(threadEntity);
    }

    public ThreadEntity update(ThreadEntity threadEntity) {
        return threadRepository.save(threadEntity);
    }

    public ThreadEntity delete(Long id) {
        ThreadEntity threadEntity = threadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Thread not found"));
        threadRepository.deleteById(id);
        return threadEntity;
    }

    public Page<ThreadEntity> getPage(Pageable pageable) {
        return threadRepository.findAll(pageable);
    }

    public Long populate(Integer amount) {
        for (int i = 0; i < amount; i++) {
            threadRepository.save(new ThreadEntity("Thread Title " + i, 1L));
        }
        return threadRepository.count();
    }
}
