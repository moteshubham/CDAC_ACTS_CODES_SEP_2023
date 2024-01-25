using Microsoft.AspNetCore.Mvc;

namespace ExceptionFiltersExample.Filters
{
    public class CustomExceptionAttribute : TypeFilterAttribute
    {
        public CustomExceptionAttribute()
           : base(typeof(CustomExceptionFilter))
        {
        }
    }
    
}
