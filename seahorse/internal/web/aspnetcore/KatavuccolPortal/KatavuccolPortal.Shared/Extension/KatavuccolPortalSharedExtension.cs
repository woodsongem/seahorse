using System.Collections.Generic;
using System.Linq;

namespace KatavuccolPortal.Shared.Extension
{
    public static class KatavuccolPortalSharedExtension
    {
        public  static bool AnyWithNullCheck<T>(this List<T> list)
        {
            if (list == null)
                return false;
            return list.Any();
        }
    }
}
