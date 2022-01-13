package com.buas.flyrest.repository

import com.buas.flyrest.model.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.REQUIRED)
interface TaskRepository : JpaRepository<Task, Long> {

    @Query(value = "SELECT * FROM tasks WHERE title=:title", nativeQuery = true)
    fun findByTitle(@Param("title") title: String): List<Task>
}


