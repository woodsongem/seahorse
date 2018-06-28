using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using KatavuccolPortalWeb.BusinessService.Services.CategoryService;
using KatavuccolPortalWeb.Mapper;
using KatavuccolPortalWeb.Models.CreateCategory;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace KatavuccolPortalWeb.Controllers.WebApi
{
    [Route("api/[controller]")]
    [ApiController]
    public class CreateCategoryController : ControllerBase
    {
        #region Local Variables

        private readonly ICategoryBusinessService categoryBusinessService;
        private readonly IKatavuccolPortalWebMapper katavuccolPortalWebMapper;

        #endregion

        #region Constructor

        public CreateCategoryController(
           ICategoryBusinessService categoryBusinessService,
           IKatavuccolPortalWebMapper katavuccolPortalWebMapper
           )
        {
            this.categoryBusinessService = categoryBusinessService;
            this.katavuccolPortalWebMapper = katavuccolPortalWebMapper;
        }

        #endregion

        #region Actions

        // GET: api/CredentialType/5
        [HttpGet("{id}", Name = "Get")]
        public IActionResult Get(string id)
        {
            CategoryBusinessMsgEntity categoryBusinessMsgEntity = categoryBusinessService.Get(id);
            if (categoryBusinessMsgEntity == null)
            {
                return NotFound();
            }
            CreateCategoryModel createCategoryModel = katavuccolPortalWebMapper.MapCreateCategoryModel(categoryBusinessMsgEntity);
            return Ok(createCategoryModel);
        }

        // POST: api/CredentialType
        [HttpPost]
        public void Post([FromBody] CreateCategoryModel createCategoryModel)
        {
            CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity = katavuccolPortalWebMapper.MapCreateCategoryMsgEntity (createCategoryModel);
            CreateCategoryBusinessResMsgEntity createCategoryBusinessResMsgEntity = categoryBusinessService.Create(createCategoryBusinessMsgEntity);

        }

        #endregion



    }
}