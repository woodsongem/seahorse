/**
 * 
 */

package seahorse.internal.business.katavuccolservice.dal;

/**
 * @author sajanmje 
 *
 */
public class KatavuccolServiceRepository implements IKatavuccolServiceRepository {

	
	/*private final IKatavuccolServiceRepositoryMapper katavuccolServiceRepositoryMapper;
	private final ICassandraConnector cassandraConnector;
	private final IReadPropertiesFile readPropertiesFile;

	@InjectLogger
	Logger logger;

	@Inject
	public KatavuccolServiceRepository(IKatavuccolServiceRepositoryMapper katavuccolServiceRepositoryMapper,
			ICassandraConnector cassandraConnector, IReadPropertiesFile readPropertiesFile) {
		this.katavuccolServiceRepositoryMapper = katavuccolServiceRepositoryMapper;
		this.cassandraConnector = cassandraConnector;
		this.readPropertiesFile = readPropertiesFile;
	}
	
	public CategoryDAO getCategoryDetailById(UUID categoryId,UUID userId)
	{
		CategoryDAO categoryDAO=null;
		try {
			cassandraConnector.connect(null, 0,null);
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_CATEGORY_DETAIL_BY_ID_QUERY);
			BoundStatement bound=katavuccolServiceRepositoryMapper.mapBoundStatement(preparedStatement,categoryId,userId);
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row categoryDAOResult = resultSet.one();
				categoryDAO = katavuccolServiceRepositoryMapper.mapCategoryDAO(categoryDAOResult);
				if(!KatavuccolServiceUtility.isEqual(categoryDAO.getStatus(), KatavuccolConstant.ACTIVESTATUS))
				{
					categoryDAO=null;
				}
			}
		} catch (Exception exception) {
			logger.error("Exception in getCategoryDetailById error=" + exception);
		}
		return categoryDAO;
	}
	
	public CredentialTypeDAO getCredentialTypeDetailById(UUID typeId,UUID userId)
	{
		CredentialTypeDAO typeDAO = null;
		try {
			cassandraConnector.connect(null, 0,null);
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_CATEGORY_TYPE_DETAILS_BY_ID_QUERY);
			BoundStatement bound=katavuccolServiceRepositoryMapper.mapCredentialTypeBoundStatement(preparedStatement,typeId,userId);			
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row typeDAOResult = resultSet.one();
				typeDAO = katavuccolServiceRepositoryMapper.mapCredentialTypeDAO(typeDAOResult);	
				if(!KatavuccolServiceUtility.isEqual(typeDAO.getStatus(), KatavuccolConstant.ACTIVESTATUS))
				{
					typeDAO=null;
				}							
			}
		} catch (Exception exception) {
			logger.error("Exception in getCredentialTypeDetailById error=" + exception);
			
		}
		return typeDAO;
	}
	
	public OutPutResponse createCredential(CredentialRequestMessageEntity credentialRequestMessageEntity)
	{
		OutPutResponse outPutResponse=new OutPutResponse();
		outPutResponse.setResultStatus(ResultStatus.SUCCESS);
		cassandraConnector.connect(null, 0,null);
		PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_CREATE_CREDENTIAL_QUERY);
		BoundStatement bound=katavuccolServiceRepositoryMapper.mapBoundStatement(preparedStatement,credentialRequestMessageEntity);
		cassandraConnector.getSession().execute(bound);
		cassandraConnector.close();
		outPutResponse.setId(credentialRequestMessageEntity.getId());
		return outPutResponse;		
	}

	public List<CategoryDAO> getCategoryDetailByUserId(UUID userId)
	{
		List<CategoryDAO> categoryDAOs = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0,null);
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_CATEGORY_DETAIL_BY_USERID_QUERY);
			BoundStatement bound=katavuccolServiceRepositoryMapper.mapBoundStatement(preparedStatement,userId);
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row categoryDAOResult = resultSet.one();
				CategoryDAO categoryDAO=katavuccolServiceRepositoryMapper.mapCategoryDAO(categoryDAOResult);
				if(KatavuccolServiceUtility.isEqual(categoryDAO.getStatus(), KatavuccolConstant.ACTIVESTATUS))
				{
					categoryDAOs.add(categoryDAO);
				}								
			}
		} catch (Exception exception) {
			logger.error("Exception in getCategoryDetailByUserId error=" + exception);			
		}
		return categoryDAOs;
	}
	
	public List<CredentialTypeDAO> getCredentialTypeByUserId(UUID userId)
	{
		List<CredentialTypeDAO> typeDAOs = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0,null);
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_CREDENTIALTYPE_DETAIL_BY_USERID_QUERY);
			BoundStatement bound=katavuccolServiceRepositoryMapper.mapCredentialTypeBoundStatement(preparedStatement,userId);			
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row typeDAOResult = resultSet.one();
				CredentialTypeDAO credentialTypeDAO=katavuccolServiceRepositoryMapper.mapCredentialTypeDAO(typeDAOResult);
				if(KatavuccolServiceUtility.isEqual(credentialTypeDAO.getStatus(), KatavuccolConstant.ACTIVESTATUS))
				{
					typeDAOs.add(credentialTypeDAO);
				}								
			}
		} catch (Exception exception) {
			logger.error("Exception in getTypeDetailsByUserId error=" + exception);
		}
		return typeDAOs;
	}

	@Override
	public List<CredentialDAO> getCredentialByUserId(UUID userId) {
		List<CredentialDAO> credentialDAOs = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0,null);
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_CREDENTIAL_DETAIL_BY_USERID_QUERY);
			BoundStatement bound=katavuccolServiceRepositoryMapper.mapCredentialBoundStatement(preparedStatement,userId);			
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row typeDAOResult = resultSet.one();
				CredentialDAO credentialDAO=katavuccolServiceRepositoryMapper.mapCredentialDAO(typeDAOResult);
				if(KatavuccolServiceUtility.isEqual(credentialDAO.getStatus(),KatavuccolConstant.ACTIVESTATUS))
				{
					credentialDAOs.add(credentialDAO);	
				}								
			}
		} catch (Exception exception) {
			logger.error("Exception in getCredentialByUserId error=" + exception);
		}
		return credentialDAOs;
	}

	@Override
	public CredentialDAO getCredentialById(UUID userId,UUID credentialId) {
		CredentialDAO credentialDAO =null;
		try {
			cassandraConnector.connect(null, 0,null);
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_CREDENTIAL_DETAIL_BY_USERID_ID_QUERY);
			BoundStatement bound=katavuccolServiceRepositoryMapper.mapGetCredentialByIdBoundStatement(preparedStatement,userId,credentialId);			
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row typeDAOResult = resultSet.one();
				CredentialDAO credentialDBDAO=katavuccolServiceRepositoryMapper.mapCredentialDAO(typeDAOResult);
				if(KatavuccolServiceUtility.isEqual(credentialDBDAO.getStatus(),KatavuccolConstant.ACTIVESTATUS))
				{
					credentialDAO=credentialDBDAO;
				}	
			}
		} catch (Exception exception) {
			logger.error("Exception in getCredentialById error=" + exception);
		}
		return credentialDAO;
	}
	
	@Override
	public CredentialDAO getCredentialById(DeleteCredentialMessageEntity deleteCredentialMessageEntity) {
		CredentialDAO credentialDAO =null;
		try {
			cassandraConnector.connect(null, 0,null);
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_CREDENTIAL_DETAIL_BY_USERID_ID_QUERY);
			BoundStatement bound=katavuccolServiceRepositoryMapper.mapGetCredentialByIdBoundStatement(preparedStatement,deleteCredentialMessageEntity);			
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row typeDAOResult = resultSet.one();
				CredentialDAO credentialDBDAO=katavuccolServiceRepositoryMapper.mapCredentialDAO(typeDAOResult);
				if(KatavuccolServiceUtility.isEqual(credentialDBDAO.getStatus(),KatavuccolConstant.ACTIVESTATUS))
				{
					credentialDAO=credentialDBDAO;
				}	
			}
		} catch (Exception exception) {
			logger.error("Exception in getCredentialById error=" + exception);
		}
		return credentialDAO;
	}

	@Override
	public OutPutResponse deleteCredential(DeleteCredentialMessageEntity deleteCredentialMessageEntity) {
		OutPutResponse outPutResponse=new OutPutResponse();
		outPutResponse.setResultStatus(ResultStatus.SUCCESS);
		cassandraConnector.connect(null, 0,null);
		PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_DELETE_CREDENTIAL_QUERY);
		BoundStatement bound=katavuccolServiceRepositoryMapper.mapBoundStatement(preparedStatement,deleteCredentialMessageEntity);
		cassandraConnector.getSession().execute(bound);
		cassandraConnector.close();		
		return outPutResponse;
	}

	@Override
	public OutPutResponse updateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		OutPutResponse outPutResponse=new OutPutResponse();
		outPutResponse.setResultStatus(ResultStatus.SUCCESS);
		cassandraConnector.connect(null, 0,null);
		PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_UPDATE_CREDENTIAL_QUERY);
		BoundStatement bound=katavuccolServiceRepositoryMapper.mapBoundStatement(preparedStatement,updateCredentialMessageEntity);
		cassandraConnector.getSession().execute(bound);
		cassandraConnector.close();		
		return outPutResponse;
	}

	@Override
	public OutPutResponse createCategory(CategoryRequestMessageEntity categoryRequestMessageEntity) {
		OutPutResponse outPutResponse=new OutPutResponse();
		outPutResponse.setResultStatus(ResultStatus.SUCCESS);
		cassandraConnector.connect(null, 0,null);
		PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_CREATE_CATEGORY_QUERY);
		BoundStatement bound=katavuccolServiceRepositoryMapper.mapBoundStatementRequest(preparedStatement,categoryRequestMessageEntity);
		cassandraConnector.getSession().execute(bound);
		cassandraConnector.close();
		return outPutResponse;	
	}

	@Override
	public OutPutResponse deleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		OutPutResponse outPutResponse=new OutPutResponse();
		outPutResponse.setResultStatus(ResultStatus.SUCCESS);
		cassandraConnector.connect(null, 0,null);
		PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_DELETE_CATEGORY_QUERY);
		BoundStatement bound=katavuccolServiceRepositoryMapper.mapBoundStatement(preparedStatement,deleteCategoryRequestMessageEntity);
		cassandraConnector.getSession().execute(bound);
		cassandraConnector.close();		
		return outPutResponse;
	}

	@Override
	public Result updateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		Result result=new Result();
		result.setResultStatus(ResultStatus.SUCCESS);
		cassandraConnector.connect(null, 0,null);
		PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_UPDATE_CATEGORY_QUERY);
		BoundStatement bound=katavuccolServiceRepositoryMapper.mapBoundStatement(preparedStatement,updateCategoryMessageEntity);
		cassandraConnector.getSession().execute(bound);
		cassandraConnector.close();		
		return result;
	}*/
}
