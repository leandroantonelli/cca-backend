package br.com.cca.commons.service;

import br.com.cca.commons.domain.AbstractDomain;

import java.util.List;

/**
 * User: Leandro Antonelli
 * Date: 15/08/20
 */
public abstract class AbstractCrudService<Domain extends AbstractDomain> extends AbstractService {

    public abstract List<Domain> findAll();

    public abstract Domain findById(Integer id);

    public abstract Domain save(Domain domain);

    public abstract void delete(Integer id);

}
