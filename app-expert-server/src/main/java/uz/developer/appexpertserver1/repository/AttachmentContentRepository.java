package uz.developer.appexpertserver1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.developer.appexpertserver1.entity.Attachment;
import uz.developer.appexpertserver1.entity.AttachmentContent;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, UUID> {
    AttachmentContent findByAttachment(Attachment attachment);
}
