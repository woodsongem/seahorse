using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.Utilities
{
    public static class KatavuccolPortalWebExtension
    {
        public static bool AnyWithNullCheck<TSource>(this IEnumerable<TSource> source)
        {
            if (source == null) return false;

            return source.Any();
        }
    }
}
