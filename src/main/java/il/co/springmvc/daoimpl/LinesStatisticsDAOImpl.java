package il.co.springmvc.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import il.co.springmvc.dao.LinesStatisticsDAO;
import il.co.springmvc.entities.LinesStatistics;

/**
 * LinesStatisticsDAOImpl represents DAO for the domain class LinesStatistics. 
 * @author Artem Meleshko
 * @version 1.0 2017
 */
@Repository
@Transactional
public class LinesStatisticsDAOImpl implements LinesStatisticsDAO{
	
	@Autowired
	SessionFactory session;

	@Override
	public LinesStatistics findId(Integer line_id) throws RuntimeException {
		LinesStatistics line = new LinesStatistics();
		line = (LinesStatistics) session.getCurrentSession().get(LinesStatistics.class, line_id);
		return line;
	}

	@Override
	public void createLineStatistic(LinesStatistics lineStatistic) throws RuntimeException {
		session.getCurrentSession().saveOrUpdate(lineStatistic);
		
	}

	@Override
	public void updateLineStatistic(LinesStatistics lineStatistic) throws IllegalArgumentException, RuntimeException {
		session.getCurrentSession().saveOrUpdate(lineStatistic);
		
	}

	@Override
	public void deleteById(LinesStatistics lineStatistic) throws RuntimeException {
		session.getCurrentSession().delete(lineStatistic);
		
	}

}
