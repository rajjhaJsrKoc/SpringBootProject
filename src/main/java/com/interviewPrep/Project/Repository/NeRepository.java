package com.interviewPrep.Project.Repository;

import com.interviewPrep.Project.entities.NetworkElement;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NeRepository extends JpaRepository<NetworkElement, Integer> {
    @Query(value = "SELECT * FROM NETWORK_ELEMENT ORDER BY id ASC LIMIT 10", nativeQuery = true)
    List<NetworkElement> findTop10();
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM NETWORK_ELEMENT  WHERE ip = :ip", nativeQuery = true)
    int deleteNetworkElementByIp(@Param("ip") int ip);

    @Query(value = "SELECT * FROM NETWORK_ELEMENT where ip =:ip", nativeQuery = true)
    Optional<NetworkElement> findNetworkElementByIp(@Param("ip") int ip);
}
