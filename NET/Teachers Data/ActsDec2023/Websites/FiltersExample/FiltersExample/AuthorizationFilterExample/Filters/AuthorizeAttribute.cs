using Microsoft.AspNetCore.Mvc;

namespace AuthorizationFilterExample.Filters
{
    public class AuthorizeAttribute : TypeFilterAttribute
    {
        public AuthorizeAttribute(string permission)
            : base(typeof(AuthorizeActionFilter))
        {
            base.Arguments = new object[] { permission };
        }
    }
}
