package org.milianz.parcial2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface iGenericRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
