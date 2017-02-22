package org.sistema.springmvc.dao;

import java.util.List;

import org.sistema.springmvc.models.Misbehaviour;

/**
 * Interface for a MisbehaviourDAO.
 * 
 * @author Eugenia Pérez Martínez.
 *
 */
public interface MisbehaviourDAO {

	/**
	 * This is the method to be used to create a record in the Student table.
	 * 
	 * @param misbehaviour
	 *            misbehaviour to be saved.
	 * 
	 * @return the ID of the saved misbehaviour.
	 */
	public Long insert(Misbehaviour misbehaviour);

	/**
	 * This is the method to be used to list down a record from the Student
	 * table corresponding to a passed student id.
	 * 
	 * @param id
	 * 
	 * @return the misbehaviour found
	 */
	public Misbehaviour selectById(Long id);

	/**
	 * This is the method to be used to list down all the records from the
	 * Student table.
	 * 
	 * @return the list of misbehaviours.
	 */
	public List<Misbehaviour> selectAll();

	/**
	 * This is the method to be used to delete a record from the Student table
	 * corresponding to a passed student id.
	 */
	public void delete(Long id);

	/**
	 * This is the method to be used to update a record into the Student table.
	 */
	public void update(Misbehaviour misbehaviour);
}
