package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MessageRepository extends JpaRepository<Message, Long> {

   /* Page<Message> findAllByChannel(String channel, Pageable pageable);

    @Modifying
    @Query(value = "update message set read_date = now() "
            + " where channel = ? and sender = ? and read_date is null", nativeQuery = true)
    void sendReadReceipt(String channel, String firstname);
*/
}
