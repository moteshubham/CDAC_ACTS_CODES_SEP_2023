using Microsoft.AspNetCore.Mvc;

namespace ResourceFiltersExample.Filters
{
    public class CacheResourceAttribute : TypeFilterAttribute
    {
        public CacheResourceAttribute()
            : base(typeof(CacheResourceFilter))
        {
        }
    }
}
