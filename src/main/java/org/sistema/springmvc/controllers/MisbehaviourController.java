package org.sistema.springmvc.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.sistema.springmvc.dao.MisbehaviourDAO;
import org.sistema.springmvc.models.Misbehaviour;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for misbehaviours.
 * 
 * @author Eugenia Pérez Martínezo
 *
 */
@Controller
public class MisbehaviourController {

	private static final Logger logger = LoggerFactory
			.getLogger(MisbehaviourController.class);

	@Autowired
	private MisbehaviourDAO misbehaviourDAO;

	/**
	 * handles default /misbehaviours
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/misbehaviours"})
	 */

	@RequestMapping(method = RequestMethod.GET, value = {"/misbehaviours" })
	public String showMisbehaviours(Map<String, Object> model) {
		logger.info("Product showMisbehaviours. ");

		List<Misbehaviour> misbehaviours = misbehaviourDAO.selectAll();
		model.put("misbehaviours", misbehaviours);
		// For the form
		model.put("misbehaviour", new Misbehaviour());

		return "misbehaviour/misbehaviours";
	}

	/**
	 * handles default /misbehaviours/id
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/misbehaviours/{id}"})
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/misbehaviours/{id}" })
	public String misbehaviourDetail(@PathVariable(value = "id") Long id,
			Map<String, Object> model) {
		logger.info("Misbehaviour detail");

		Misbehaviour misbehaviour = misbehaviourDAO.selectById(id);
		model.put("misbehaviour", misbehaviour);

		return "misbehaviour/misbehaviourDetail";
	}

	/**
	 * handles /misbehaviours/new
	 * 
	 * @return the name of the view to show RequestMapping({"/misbehaviours/new"})
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/misbehaviours/new" })
	public String newMisbehaviour(Map<String, Object> model) {
		logger.info("Showing custom view GET ");

		model.put("misbehaviour", new Misbehaviour());

		return "misbehaviour/newMisbehaviour";
	}

	/**
	 * handles /misbehaviours/new by POST
	 * 
	 * @return the name of the view to show RequestMapping({"/misbehaviours/new"})
	 */
	@RequestMapping(method = RequestMethod.POST, value = { "/misbehaviours/new" })
	public ModelAndView createMisbehaviour(Misbehaviour misbehaviour) {

		ModelAndView modelAndView = new ModelAndView();

		/*if (bindingResult.hasErrors()) {
			modelAndView.setViewName("misbehaviour/newMisbehaviour");
			modelAndView.addObject("misbehaviour", misbehaviour);
			return modelAndView;
		}*/

		if (misbehaviourDAO.insert(misbehaviour) > 0) {
			logger.info("Saveview POST " + misbehaviour.getId());
			// We return view name
			modelAndView.setViewName("misbehaviour/created");
			modelAndView.addObject("misbehaviour", misbehaviour);
		} else {
			modelAndView.setViewName("error");
			modelAndView
					.addObject("error",
							"An error ocurred while trying to create a new misbehaviour. Please, try again");
		}
		return modelAndView;
	}

	/**
	 * Simply selects the update view
	 */
	@RequestMapping(value = "/misbehaviours/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable(value = "id") Long misbehaviourId, Model model) {
		logger.info("Showing update view GET ");

		// We find the product through DAO and load into model
		model.addAttribute("misbehaviour", misbehaviourDAO.selectById(misbehaviourId));

		return "misbehaviour/update";
	}

	/**
	 * Handles the POST from the Custom.jsp page to update the Misbehaviour.
	 */
	@RequestMapping(value = "/misbehaviours/saveupdate", method = RequestMethod.POST)
	public ModelAndView saveUpdate(Misbehaviour misbehaviour) {
		logger.info("Save update " + misbehaviour.getId());

		misbehaviourDAO.update(misbehaviour);

		ModelAndView modelAndView = new ModelAndView();

		// We pass the misbehaviour received through this object
		modelAndView.addObject("misbehaviour", misbehaviour);

		// The same as return "misbehaviour/saveUpdate"
		modelAndView.setViewName("misbehaviour/saveUpdated");
		return modelAndView;
	}

	/**
	 * Delete the specific misbehaviour
	 */
	@RequestMapping(value = "/misbehaviours/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value = "id") Long misbehaviourId, Model model) {
		logger.info("Product detail /delete");

		misbehaviourDAO.delete(misbehaviourId);
		model.addAttribute("misbehaviourId", misbehaviourId);

		return "misbehaviour/deleted";
	}

}
