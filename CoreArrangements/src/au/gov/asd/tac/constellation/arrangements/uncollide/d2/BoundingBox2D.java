/*
 * Copyright 2010-2019 Australian Signals Directorate
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package au.gov.asd.tac.constellation.arrangements.uncollide.d2;

/**
 *
 * @author algol
 */
public class BoundingBox2D {

    public static Box2D getBox(final Orb2D[] orbs) {
        final Orb2D orb0 = orbs[0];
        float minx = orb0.x;
        float miny = orb0.y;
        float maxx = minx;
        float maxy = miny;

        for (final Orb2D orb : orbs) {
            final float x = orb.x;
            final float y = orb.y;
            if (x < minx) {
                minx = x;
            }
            if (x > maxx) {
                maxx = x;
            }
            if (y < miny) {
                miny = y;
            }
            if (y > maxy) {
                maxy = y;
            }
        }

        return new Box2D(minx, miny, maxx, maxy);
    }

    public static class Box2D {

        public final float minx;
        public final float miny;
        public final float maxx;
        public final float maxy;

        public Box2D(final float minx, final float miny, final float maxx, final float maxy) {
            this.minx = minx;
            this.miny = miny;
            this.maxx = maxx;
            this.maxy = maxy;
        }

        @Override
        public String toString() {
            return String.format("[Box2D %f %f %f %f]", minx, miny, maxx, maxy);
        }
    }
}
