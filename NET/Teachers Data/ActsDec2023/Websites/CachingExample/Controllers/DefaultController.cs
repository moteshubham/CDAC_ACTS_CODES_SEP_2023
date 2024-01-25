using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Caching.Memory;

namespace CachingExample.Controllers
{
    public class DefaultController : Controller
    {
        private IMemoryCache cache;
        public DefaultController(IMemoryCache memoryCache)
        {
            cache = memoryCache;
        }
        public IActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public IActionResult CreateCacheEntry()
        {
            return View();
        }
        [HttpPost]
        public IActionResult CreateCacheEntry(IFormCollection collection, string txtKey1, string txtKey2)
        {
            if (collection["Save"] == "Save") //save button clicked
            {

                string txtkey1value = collection["txtKey1"];
                string txtkey2value = collection["txtKey2"];
                //cache.Set("key1", txtkey1value); //no expiration
                //cache.Set("key2", txtkey2value); //no expiration

                //cache.Set("key1", txtkey1value, DateTime.Now.AddSeconds(30)); //absolute expiration
                //cache.Set("key2", txtkey2value, DateTime.Now.AddSeconds(30)); //absolute expiration



                //MemoryCacheEntryOptions CacheOptions =
                //    new MemoryCacheEntryOptions { SlidingExpiration = TimeSpan.FromSeconds(10) };
                //MemoryCacheEntryOptions CacheOptions2 =
                //    new MemoryCacheEntryOptions
                //    {
                //        SlidingExpiration = TimeSpan.FromSeconds(5),
                //        AbsoluteExpiration = DateTime.Now.AddMinutes(1)
                //    };
                //MemoryCacheEntryOptions CacheOptions3 =
                //    new MemoryCacheEntryOptions { Priority = CacheItemPriority.NeverRemove };
                MemoryCacheEntryOptions CacheOptions4 =
                    new MemoryCacheEntryOptions { AbsoluteExpiration = DateTime.Now.AddSeconds(5) };
                CacheOptions4.RegisterPostEvictionCallback(PostEvictionCallback);


                cache.Set("key1", txtkey1value, CacheOptions4); //sliding expiration
                cache.Set("key2", txtkey2value, CacheOptions4); //sliding expiration

                
            }
            return View();
        }
        
        public IActionResult DisplayCacheEntry()
        {
            string key1value, key2value;
            
            if (!cache.TryGetValue("key1", out key1value))
                key1value = "default key1 value when not in cache";

            if (!cache.TryGetValue("key2", out key2value))
                key2value = "default key2 value when not in cache";

            ViewBag.key1 = key1value;
            ViewBag.key2 = key2value;


            return View();
        }

        private static void PostEvictionCallback(
    object cacheKey, object cacheValue, EvictionReason evictionReason, object state)
        {
            var memoryCache = (IMemoryCache)state;
            //if(evictionReason== EvictionReason.)
          //memoryCache.Set()
        }


    }
}


//https://learn.microsoft.com/en-us/aspnet/core/performance/caching/memory?view=aspnetcore-6.0