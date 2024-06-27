package com.api.crud_api_rest.repositorios;

import com.api.crud_api_rest.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**Clase de query a BD*/
@Repository
public interface IUserRepositorio extends JpaRepository<UserModel, Long> {
}
