using System;
using System.Collections.Generic;
using System.Linq;

namespace ColdFishServiceOpenApi.Commons
{
    public static class ColdFishServiceOpenApiExtension
    {

        public static bool AnyWithNullCheck<TSource>(this IEnumerable<TSource> source, Func<TSource, bool> predicate = null)
        {
            if (source == null)
                return false;

            if (predicate == null)
                return source.Any();

            return source.Any(predicate);
        }
        public static bool IsEmpty(this string value)
        {
            if (value == null)
                return false;
            return string.IsNullOrWhiteSpace(value);
        }
    }
}
