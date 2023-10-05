package net.ausiasmarch.foxforumserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.foxforumserver.entity.ReplyEntity;
import net.ausiasmarch.foxforumserver.entity.UserEntity;
import net.ausiasmarch.foxforumserver.exception.ResourceNotFoundException;
import net.ausiasmarch.foxforumserver.repository.ReplyRepository;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public ReplyEntity get(Long id) {
        return replyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reply not found"));
    }

    public ReplyEntity create(ReplyEntity replyEntity) {
        replyEntity.setId(null);
        return replyRepository.save(replyEntity);
    }

    public ReplyEntity update(ReplyEntity replyEntity) {
        return replyRepository.save(replyEntity);
    }

    public ReplyEntity delete(Long id) {
        ReplyEntity replyEntity = get(id);
        replyRepository.deleteById(id);
        return replyEntity;
    }

    public Page<ReplyEntity> getPage(Pageable pageable) {
        return replyRepository.findAll(pageable);
    }

    public Long populate(Integer amount) {
        for (int i = 0; i < amount; i++) {
            replyRepository.save(new ReplyEntity("Title " + i, "Body " + i, 1L, 1L));
        }
        return replyRepository.count();
    }
}
