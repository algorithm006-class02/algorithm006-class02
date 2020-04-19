<?php

/**
 * 146 design LRUcache
 */
class LRUCache
{
    private $capacity;
    private $size = 0;
    private $cache;

    /**
     * @param Integer $capacity
     */
    function __construct($capacity)
    {
        $this->capacity = $capacity;
    }

    /**
     * @param Integer $key
     * @return Integer
     */
    function get($key)
    {
        if (isset($this->cache[$key])) {
            $value = $this->cache[$key];
            unset($this->cache[$key]);
            $this->cache[$key] = $value;
            return $value;
        }
        return -1;
    }

    /**
     * @param Integer $key
     * @param Integer $value
     * @return NULL
     */
    function put($key, $value)
    {
        if (isset($this->cache[$key])) {
            unset($this->cache[$key]);
            $this->cache[$key] = $value;
        } else {
            if ($this->size < $this->capacity) {
                $this->size++;
            } else {
                $curr_key = key($this->cache);
                unset($this->cache[$curr_key]);
            }
            $this->cache[$key] = $value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * $obj = LRUCache($capacity);
 * $ret_1 = $obj->get($key);
 * $obj->put($key, $value);
 */