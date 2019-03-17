using System;
namespace ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities
{
    public class SecurityQuestionMessageEntity
    {
        public int? SecurityQuestionId { get; set; }

        public string SecurityQuestionAnswer { get; set; }
    }
}
