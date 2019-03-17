using System;
using System.Collections.Concurrent;
using ColdFishServiceOpenApi.Commons;
using ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities;
using ColdFishServiceOpenApiWebApiModel.CustomerService;

namespace ColdFishServiceOpenApiWebApi.Mappers
{
    public class CustomerServiceApiMapper : ICustomerServiceApiMapper
    {
        public CreateUserMessageEntity MapCreateUserMessageEntity(CreateCustomerRequestModel createCustomerRequestModel)
        {
            CreateUserMessageEntity createUserMessageEntity = new CreateUserMessageEntity
            {
                Addresses = new ConcurrentBag<AddressMessageEntity>(),
                Credential = new CredentialMessageEntity
                {
                    Password = createCustomerRequestModel.CustomerDetail.Credential?.UserName,
                    UserName = createCustomerRequestModel.CustomerDetail.Credential?.Password,
                    SecurityQuestions = new ConcurrentBag<SecurityQuestionMessageEntity>()
                },
                EmailAddresses = new ConcurrentBag<EmailAddressMessageEntity>(),
                Name = new NameMessageEntity
                {
                    FirstName = createCustomerRequestModel.CustomerDetail.Name?.FirstName,
                    LastName = createCustomerRequestModel.CustomerDetail.Name?.LastName,
                    MiddleName = createCustomerRequestModel.CustomerDetail.Name?.MiddleName
                },
                Occupation = new ConcurrentBag<OccupationMessageEntity>(),
                Phones = new ConcurrentBag<PhoneMessageEntity>()
            };

            if (createCustomerRequestModel.CustomerDetail.Credential.SecurityQuestions.AnyWithNullCheck())
            {
                foreach (SecurityQuestionModel securityQuestionModel in createCustomerRequestModel.CustomerDetail.Credential.SecurityQuestions)
                {
                    createUserMessageEntity.Credential.SecurityQuestions.Add(new SecurityQuestionMessageEntity
                    {
                        SecurityQuestionAnswer = securityQuestionModel.SecurityQuestionAnswer,
                        SecurityQuestionId = securityQuestionModel.SecurityQuestionId
                    });
                }
            }
            if (createCustomerRequestModel.CustomerDetail.Addresses.AnyWithNullCheck())
            {
                foreach (AddressModel addressModel in createCustomerRequestModel.CustomerDetail.Addresses)
                {
                    createUserMessageEntity.Addresses.Add(new AddressMessageEntity
                    {
                        AddressLine1 = addressModel.AddressLine1,
                        AddressLine2 = addressModel.AddressLine2,
                        CityCode = addressModel.CityCode,
                        CountryCode = addressModel.CountryCode,
                        IsPrimary = addressModel.IsPrimary,
                        StateCode = addressModel.StateCode
                    });
                }
            }
            if (createCustomerRequestModel.CustomerDetail.EmailAddresses.AnyWithNullCheck())
            {
                foreach (EmailAddressModel emailAddressModel in createCustomerRequestModel.CustomerDetail.EmailAddresses)
                {
                    createUserMessageEntity.EmailAddresses.Add(new EmailAddressMessageEntity
                    {
                        EmailAddress = emailAddressModel.EmailAddress,
                        IsPrimary = emailAddressModel.IsPrimary
                    });
                }
            }

            if (createCustomerRequestModel.CustomerDetail.Phones.AnyWithNullCheck())
            {
                foreach (PhoneModel phoneModel in createCustomerRequestModel.CustomerDetail.Phones)
                {
                    createUserMessageEntity.Phones.Add(new PhoneMessageEntity
                    {
                        IsPrimary = phoneModel.IsPrimary,
                        CountryCode = phoneModel.CountryCode,
                        PhoneNumber = phoneModel.PhoneNumber
                    });
                }
            }

            return createUserMessageEntity;
        }
    }
}
